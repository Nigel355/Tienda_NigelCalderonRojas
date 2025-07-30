/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.controller;
import Tienda.Web.domain.Usuario;
import Tienda.Web.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author nigel
 */

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
//obtiene la lista de todos los usuarios, mostrando la vista de usuario/listado.html
    @GetMapping("/listado")
    public String listado(Model model) {
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/usuario/listado";
    }
//crea un nuevo objeto usuario para el formulario mediante el usuario/modifica.html
    @GetMapping("/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modifica";
    }

   
    
//busca un usuario por el id y lo elimina
    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }
//busca un usuario por su id para luego modificar el usuario con la misma id para modificarlo
    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
}