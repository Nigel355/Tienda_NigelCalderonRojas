/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.dao;
import Tienda.Web.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author nigel
 */
// es la creacion del dao de usuario definiendo los metodos para buscar a los usuarios por el nombre de usuario contraseña o su correo
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
}