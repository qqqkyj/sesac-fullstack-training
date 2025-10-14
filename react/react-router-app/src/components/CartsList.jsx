import axios from "axios";
import { useState, useEffect } from "react";

export default function CartsList() {
  const [carts, setCarts] = useState([]);

  useEffect(() => {
    async function getCarts() {
      const response = await axios.get("https://dummyjson.com/carts");
      const data = response.data.carts;
      console.log(data);
      setCarts(data);
    }
    getCarts();
  }, []);

  return (
    <div>
      {carts.map((cart) => {
        return (
          <div>
            No.{cart.id} 장바구니
            {cart.products.map((product) => {
              return (
                <div>
                  {product.title} - {product.price}
                </div>
              );
            })}
            <hr />
          </div>
        );
      })}
    </div>
  );
}
