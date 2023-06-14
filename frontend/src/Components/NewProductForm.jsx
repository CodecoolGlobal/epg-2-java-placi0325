
const NewProductForm = ( {onCancel, onSave }) => {

  const onSubmit = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entries = [...formData.entries()];

    const product = entries.reduce((acc, entry) => {
      const [k, v] = entry;
      acc[k] = v;
      return acc;
    }, {});

    console.log(product)
    return onSave(product);
  };

    

  return (
    <div>
      <div>
        <form onSubmit={onSubmit}>
          <h1>Upload the item you want to sell!</h1>
          <div>
            <label htmlFor="name">Product name:</label>
            <input
              defaultValue={"Please write in the item name"}
              name="name"
              id="name"
            />

            <label htmlFor="description">Product description:</label>
            <input
              defaultValue={"Details about the product"}
              name="description"
              id="description"
            />

            <label htmlFor="price">Price:</label>
            <input
              type="number"
              defaultValue={"The price of the product"}
              name="price"
              id="price"
            />

            <button className="button" type="submit">
              Upload
            </button>
            <button className="button" type="button" onClick={onCancel}>
              Cancel
            </button>

          </div>
        </form>
      </div>
    </div>
  );
};

export default NewProductForm;
