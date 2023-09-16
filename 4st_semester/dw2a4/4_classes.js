class Product {
    #name
    #description
    #price
    #barCode

    constructor(name, description, price, barCode) {
        this.#name = name
        this.#description = description
        this.#price = price
        this.#barCode = barCode
    }

    get name() {
        return this.#name
    }

    set name(newName) {
        this.#name = newName
    }

    get description() {
        return this.#description
    }

    set description(newDescription) {
        this.#description = newDescription
    }

    get price() {
        return this.#price
    }

    set price(newPrice) {
        this.#price = newPrice
    }

    get barCode() {
        return this.#barCode
    }

    set barCode(newBarCode) {
        this.#barCode = newBarCode
    }

    calculateDiscount(percentage) {
        let priceWithDiscount = this.#price - (this.#price*(percentage/100))
        this.#price = priceWithDiscount
        return priceWithDiscount
    }

    increasePrice(percentage) {
        let priceWithIncrease = this.#price + (this.#price*(percentage/100))
        this.#price = priceWithIncrease
        return priceWithIncrease
    }

}


class Smartwatch extends Product {
    #brand

    constructor(name, description, price, barCode, brand) {
        super(name, description, price, barCode)
        this.#brand = brand
    }

    get brand() {
        return this.#brand
    }

    set brand(newBrand) {
        this.#brand = newBrand
    }

    calculateDiscount(percentage) {
        if(percentage <= 14) {
            let priceWithDiscount = this.price - (this.price*(percentage/100))
            this.price = priceWithDiscount
            return priceWithDiscount
        }
        return "Discount Error"
    }

}

class Smartphone extends Product {
    #brand

    constructor(name, description, price, barCode, brand) {
        super(name, description, price, barCode)
        this.#brand = brand
    }

    get brand() {
        return this.#brand
    }

    set brand(newBrand) {
        this.#brand = newBrand
    }

    calculateDiscount(percentage) {
        if(percentage <= 18) {
            let discountPrice = super.price*(percentage/100)
            if(discountPrice <= 132) {
                let priceWithDiscount = this.price - discountPrice
                return priceWithDiscount
            }
        }
        return "Discount Error"
    }
}

class Laptop extends Product {
    #brand

    constructor(name, description, price, barCode, brand) {
        super(name, description, price, barCode)
        this.#brand = brand
    }

    get brand() {
        return this.#brand
    }

    set brand(newBrand) {
        this.#brand = newBrand
    }

    calculateDiscount(percentage) {
        let discountPrice = this.price*(percentage/100)
        if(discountPrice >= 99 && discountPrice <= 305) {
            let priceWithDiscount = this.price - discountPrice
            return priceWithDiscount
        }
        return "Discount Error"
    }

}

const smartwatch = new Smartwatch("Apple Watch", "Smartwatch developed by Apple", 2500, "123456789", "Apple")
console.log(smartwatch.calculateDiscount(15))

const smartphone = new Smartphone("Iphone", "Smartphone developed by Apple", 4000, "987654321", "Apple")
console.log(smartphone.calculateDiscount(1))

const laptop = new Laptop("MacBook Air", "Laptop developed by Apple", 10000, "654321987", "Apple")
console.log(laptop.calculateDiscount(10))