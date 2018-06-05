package guru.springframework.services;

import guru.springframework.commands.ProductForm;
import guru.springframework.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface TeamService {

    public boolean insertTeamData(String fileName);

}
