/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.service;
import Tienda.Web.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author nigel
 */
//creacion del registro service se crean los metodos que se implementaran mas adelante
//activando usuario creando usuario activando un usuario y recordando un usauro con excepciones por si llega a ocurrir un error
public interface RegistroService {

    public Model activar(Model model, String usuario, String clave);

    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException;
    
    public void activar(Usuario usuario, MultipartFile imagenFile);
    
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException;
}

