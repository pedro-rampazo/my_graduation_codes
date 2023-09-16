function Product(name, description, price, barCode){
    Object.defineProperties(this, {
        name: {
            configurable: false,
            get() {
                return name
            },
            set(newName) {
                name = newName
            },
        },
        description: {
            configurable: false,
            get() {
                return description
            },
            set(newDescription) {
                description = newDescription
            },
        },
        price: {
            configurable: false,
            get() {
                return price
            },
            set(newPrice) {
                if (newPrice > 0) {
                    price = newPrice
                } else {
                    console.log("Price can't be negative.")
                }
            },
        },
        barCode: {
            configurable: false,
            get() {
                return barCode
            },
            set(newBarCode) {
                barCode = newBarCode
            },
        },
    })
}

Product.prototype.calculateDiscount = function(percentage) {
    let priceWithDiscount = this.price - (this.price*(percentage/100))
    this.price = priceWithDiscount
    return priceWithDiscount
}

Product.prototype.increasePrice = function(percentage) {
    let priceWithIncrease = this.price + (this.price*(percentage/100))
    this.price = priceWithIncrease
    return priceWithIncrease
}

const product1 = new Product("Product One", "Description Product One", 15.0, "123456789")
const product2 = new Product("Product Two", "Description Product Two", 150.15, "987654321")
const product3 = new Product("Product Three", "Description Product Three", 88.8, "654321987")

product1.calculateDiscount(10)
console.log(product1.price)
product1.increasePrice(20)
console.log(product1.price)

product2.calculateDiscount(30)
console.log(product2.price)
product2.increasePrice(40)
console.log(product2.price)

product3.calculateDiscount(50)
console.log(product3.price)
product3.increasePrice(60)
console.log(product3.price)