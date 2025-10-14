import { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";

export default function ProductDetail() {
  const [product, setProduct] = useState({});
  const { productId } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    async function getProduct() {
      const response = await axios(
        `https://dummyjson.com/products/${productId}`
      );
      setProduct(response.data);
    }
    getProduct();
  }, []);

  return (
    <div>
      <button
        className="border-2 p-1 cursor-pointer"
        onClick={() => {
          navigate(-1);
        }}
      >
        뒤로가기
      </button>
      <div className="text-4xl">{product.title}</div>
      <div>
        <p className="text-2xl">{product.description}</p>
      </div>
    </div>
  );
}
