/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: ShoppingListServiceMap.java is a class which extends the AbstractMapService and works with
 * ShoppingList & Long objects. Overrides methods & implements shoppinglist specific logic
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.model.ShoppingList;
import ca.gbc.comp3095.cookbook.repositories.ShoppingListRepository;
import ca.gbc.comp3095.cookbook.services.ShoppingListService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service // Annotates this class as a Service to be managed by Spring Boot
public class ShoppingListServiceMap extends AbstractMapService<ShoppingList, Long> implements ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListServiceMap(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public Set<ShoppingList> findAll() {
        return super.findAll(shoppingListRepository);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(shoppingListRepository, id);
    }

    @Override
    public void delete(ShoppingList object) {
        super.delete(shoppingListRepository, object);
    }

    @Override
    public ShoppingList findById(Long id) {
        ShoppingList toReturn =  super.findById(shoppingListRepository, id);

        if (toReturn == null) {
            toReturn = new ShoppingList();
            toReturn.setId(-1L);
        }

        return toReturn;
    }

    @Override
    public ShoppingList save(ShoppingList shoppingList) {
        return super.save(shoppingListRepository, shoppingList);
    }

    @Override
    public Set<ShoppingList> findAllByUserId(Long id) {
        return shoppingListRepository.findAllByUserId(id);
    }
}
