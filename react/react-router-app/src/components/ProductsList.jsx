import axios from "axios";
import { useState, useEffect } from "react";
import { Link, useSearchParams } from "react-router-dom";

export default function ProductsList() {
  const [total, setTotal] = useState(0);
  const [products, setProducts] = useState([]);
  const [searchParams, setSearchParams] = useSearchParams();

  const skip = searchParams.get("skip") ?? 0;
  const sortBy = searchParams.get("sortBy") ?? "id";
  const order = searchParams.get("order") ?? "asc";

  useEffect(() => {
    async function getProducts() {
      const response = await axios.get(
        `https://dummyjson.com/products?limit=5&skip=${skip}&sortBy=${sortBy}&order=${order}`
      );
      const data = response.data.products;
      setProducts(data);
      console.log(response.data.total);
      setTotal(response.data.total);
    }
    getProducts();
  }, [searchParams]);

  return (
    <div className="flex flex-col gap-4 items-center">
      <div className="flex gap-2">
        <button
          className="border-2 p-1 cursor-pointer"
          onClick={() => {
            setSearchParams({});
          }}
        >
          초기화
        </button>
        <button
          className="border-2 p-1 cursor-pointer"
          onClick={() => {
            if (Number(skip) - 5 >= 0) {
              setSearchParams({
                skip: Number(skip) - 5,
                order,
                sortBy,
              });
            }
          }}
        >
          이전
        </button>
        <button
          className="border-2 p-1 cursor-pointer"
          onClick={() => {
            if (Number(skip) + 5 <= total) {
              /*
               setSearchParams({
                  skip: Number(skip) + 5,
                  order,
                  sortBy,
                });
               */
              // 변경을 원하는 쿼리 파라미터 속성의 값만 변경
              setSearchParams((searchParams) => {
                searchParams.set("skip", Number(skip) + 5);
                return searchParams;
              });
            }
          }}
        >
          다음
        </button>
      </div>
      <div className="flex gap-2">
        <button
          className="border-2 p-1 cursor-pointer"
          onClick={() => {
            setSearchParams({
              skip: 0,
              order: "asc",
              sortBy: "id",
            });
          }}
        >
          ID 오름차순
        </button>
        <button
          className="border-2 p-1 cursor-pointer"
          onClick={() => {
            setSearchParams({
              skip: 0,
              order: "desc",
              sortBy: "id",
            });
          }}
        >
          ID 내림차순
        </button>
        <button
          className="border-2 p-1 cursor-pointer"
          onClick={() => {
            setSearchParams({
              skip: 0,
              order: "asc",
              sortBy: "price",
            });
          }}
        >
          가격 오름차순
        </button>
        <button
          className="border-2 p-1 cursor-pointer"
          onClick={() => {
            setSearchParams({
              skip: 0,
              order: "desc",
              sortBy: "price",
            });
          }}
        >
          가격 내림차순
        </button>
      </div>
      <div>
        {products.map((product) => {
          return (
            <div key={product.id}>
              <Link to={`/dummy/products/${product.id}`}>
                No.{product.id} - {product.title} - {product.price}
              </Link>
            </div>
          );
        })}
      </div>
      <div className="flex gap-4">
        <div>정렬 기준: {sortBy}</div>
        <div>정렬 순서: {order}</div>
        <div>페이지 번호: {skip / 5 + 1}</div>
      </div>
    </div>
  );
}
