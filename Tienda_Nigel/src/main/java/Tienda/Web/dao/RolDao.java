/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.dao;
import Tienda.Web.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nigel
 */
//creacion del dao del rol
public interface RolDao extends JpaRepository<Rol, Long> {

}
