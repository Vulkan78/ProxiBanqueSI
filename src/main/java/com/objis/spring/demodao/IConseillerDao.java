package com.objis.spring.demodao;
import com.objis.spring.demodomaine.ConseillerClientele;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Jimmy Rakotoson, José-Alexandre Giry
 *
 */

public interface IConseillerDao extends JpaRepository<ConseillerClientele, Integer> {

    List<ConseillerClientele> findByNomContaining(String keyword);
}
