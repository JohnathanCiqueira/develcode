package com.develcode.avaliacao.usuario.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.develcode.avaliacao.usuario.dto.UsuarioDTO;
import com.develcode.avaliacao.usuario.model.Usuario;
import com.develcode.avaliacao.usuario.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "listar-um")
	public ResponseEntity<Object> buscarUsuarioPorCodigo(@RequestParam("codigo") Long codigo) {
		return usuarioService.findOne(codigo);
	}

	@GetMapping(value = "listar-todos")
	public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
		return usuarioService.listarTodosUsuarios();
	}

//	@PostMapping(value = "cadastrar")
//	public ResponseEntity<Object> cadastrarUsuario(@RequestPart  @Valid UsuarioDTO usuarioDTO, @RequestParam("foto") MultipartFile file){
//		return usuarioService.cadastrar(usuarioDTO, file);
//	}

	@PostMapping(value = "cadastrar")
	public ResponseEntity<Object> cadastrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		return usuarioService.cadastrar(usuarioDTO);
	}

	@PostMapping(value = "upload-imagem")
	public ResponseEntity<Object> atualizarImagemUsuario(@RequestParam("codigo") Long codigo,
			@RequestParam("foto") MultipartFile file) {
		return usuarioService.uploadImagem(codigo, file);
	}

	@PatchMapping(value = "atualizar")
	public ResponseEntity<Object> atualizarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.atualizar(usuario);
	}

	@DeleteMapping(value = "remover")
	public ResponseEntity<Object> removerUsuario(@RequestParam("codigo") Long codigo) {
		return usuarioService.deletar(codigo);
	}

}