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


function Smartwatch(name, description, price, barCode) {
    Product.call(this, name, description, price, barCode)
}
Smartwatch.prototype = Object.create(Product.prototype)
Smartwatch.prototype.constructor = Smartwatch
Smartwatch.prototype.calculateDiscount = function(percentage) {
    if(percentage <= 10) {
        let priceWithDiscount = this.price - (this.price*(percentage/100))
        this.price = priceWithDiscount
        return priceWithDiscount
    }
    console.log("Discount bigger than 10%")
}

function Smartphone(name, description, price, barCode) {
    Product.call(this, name, description, price, barCode)
}
Smartphone.prototype = Object.create(Product.prototype)
Smartphone.prototype.constructor = Smartphone
Smartphone.prototype.calculateDiscount = function(percentage) {
    if(percentage <= 15) {
        let discountPrice = this.price*(percentage/100)
        if(discountPrice < 115) {
            let priceWithDiscount = this.price - discountPrice
            return priceWithDiscount
        }
        console.log("Discount bigger than 115")
    }
    console.log("Discount bigger than 15%")
}


function Laptop(name, description, price, barCode) {
    Product.call(this, name, description, price, barCode)
}
Laptop.prototype = Object.create(Product.prototype)
Laptop.prototype.constructor = Laptop
Laptop.prototype.calculateDiscount = function(percentage) {
    let discountPrice = this.price*(percentage/100)
    if(discountPrice >= 97 && discountPrice <= 305) {
        let priceWithDiscount = this.price - discountPrice
        return priceWithDiscount
    }
    console.log("Discount Error")
}

const smartwatch = new Smartwatch("AppleWatch", "smartwatch developed by Apple", 1500, "123456789")
console.log(smartwatch.name)
console.log(smartwatch.description)
console.log(smartwatch.price)
console.log(smartwatch.barCode)
console.log(smartwatch.calculateDiscount(10))
console.log(smartwatch.calculateDiscount(11))

const smartphone = new Smartphone("IPhone XIV", "smartphone developed by Apple", 8400, "987645321")
console.log(smartphone.name)
console.log(smartphone.description)
console.log(smartphone.price)
console.log(smartphone.barCode)
console.log(smartphone.calculateDiscount(1))
console.log(smartphone.calculateDiscount(2))

const laptop = new Laptop("MacBook Air", "laptop developed by Apple", 6700, "654321987")
console.log(laptop.name)
console.log(laptop.description)
console.log(laptop.price)
console.log(laptop.barCode)
console.log(laptop.calculateDiscount(1))
console.log(laptop.calculateDiscount(2))
