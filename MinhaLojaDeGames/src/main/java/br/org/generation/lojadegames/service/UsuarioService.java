package br.org.generation.lojadegames.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.generation.lojadegames.model.Usuario;
import br.org.generation.lojadegames.model.UsuarioLogin;
import br.org.generation.lojadegames.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> cadastrarUsuario(Usuario user){
		
		if(usuarioRepository.findByUsername(user.getUsername()).isPresent())
			return Optional.empty();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(user.getPassword());
		user.setPassword(senhaEncoder);
		
		return Optional.of(usuarioRepository.save(user));
	}
	
	public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<Usuario> usuario = usuarioRepository.findByUsername(user.get().getUsernamelog());
		
		if (usuario.isPresent()) {
			
			if (encoder.matches(user.get().getPasswordlog(), usuario.get().getPassword())) {
				
				String auth = user.get().getUsernamelog() + ":" + user.get().getPasswordlog();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				
				user.get().setNamelog(usuario.get().getName());
				user.get().setPasswordlog(usuario.get().getPassword());
				user.get().setToken(authHeader);
				
				return user;
			}
		}
		return Optional.empty();
	}

}
