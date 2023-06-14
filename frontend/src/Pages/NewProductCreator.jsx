import { useState } from "react";
import { useNavigate } from "react-router-dom";
import NewProductForm from "../Components/NewProductForm";
import Loading from "./Loading/Loading";



const createProduct= (product) => {
    return fetch("/products", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(product),
    }).then((res) => res.json());
  };


const NewProductCreator = () =>  {
    const [loading, setLoading] = useState();
    const navigate = useNavigate();

    const handleCreateProduct = (product) => {
        setLoading(true);
    
        createProduct(product)
          .then(() => {
            navigate("/products");
          })
          .catch((err) => {
            throw err;
          })
          .finally(() => {
            setLoading(false);
          });
      };

    if (loading) {
        return <Loading />;
    }

      return (
        <NewProductForm
          onCancel={() => navigate("/products")}
          onSave={handleCreateProduct}
        />
      );


}

export default NewProductCreator;