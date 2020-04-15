package com.tim19.weblab.controller;


import com.tim19.weblab.dto.CartitemDto;
import com.tim19.weblab.error.CartitemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cartitems")
public class CartitemsController {

    private List<CartitemDto> cartItems = new ArrayList<CartitemDto>();
    private int maxid = 3;

    public CartitemsController() {
        cartItems.add(new CartitemDto(1, "Coronabier"));
        cartItems.add(new CartitemDto(2, "Klopapier"));
        cartItems.add(new CartitemDto(3, "Desinkfektionsmittel"));
    }

    @GetMapping
    public List<CartitemDto> getItems() {
        return cartItems;
    }

    @PostMapping
    public void createCartitem(@RequestBody CartitemDto cartitem) {
        cartitem.setId(++maxid);
        cartItems.add(cartitem);
    }

    @GetMapping(value="{id}")
    public CartitemDto getById(@PathVariable("id") Integer id) throws CartitemNotFoundException{
        for(CartitemDto cartitem: cartItems) {
            if(cartitem.getId()==id) {
                return cartitem;
            }
        }
        throw new CartitemNotFoundException(String.format("No cartitem with id %d found", id));
    }

    @DeleteMapping(value="{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCartitem(@PathVariable("id") Integer id) throws CartitemNotFoundException{
        if (!cartItems.removeIf(cartitem -> cartitem.getId() == id)) {
            throw new CartitemNotFoundException(String.format("No cartitem with id %d found", id));
        }
    }

    @PutMapping(value="{id}")
    public CartitemDto update(@PathVariable("id") Integer id, @RequestBody CartitemDto cartitemDto) throws CartitemNotFoundException{
        for (CartitemDto cartitem: cartItems) {
            if(cartitem.getId()== cartitemDto.getId()) {
                cartitem.setName(cartitemDto.getName());
                return cartitem;
            }
        }
        throw new CartitemNotFoundException(String.format("No cartitem with id %d found", id));
    }


}
