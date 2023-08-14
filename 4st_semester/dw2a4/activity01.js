//  ● Implemente um objeto que represente um círculo com três
//    atributos de PI (3.14, 3.14159, 3.1415926536) e um de raio

//  ● Implemente dois métodos: um para o cálculo da área e outro para
//    o perímetro do círculo

//  ● Implemente um método que imprime os diferentes valores de área
//    e perímetro do círculo para os diferentes valores de PI

//  ● Considere o Object.defineProperties() para:
//    ○ Definir os getters e setters dos atributos
//    ○ Não permitir a exclusão dos atributos

function Circle(radius){
    Object.defineProperties(this, {
        radius: {
            configurable: false,
            get() {
                return radius
            },
            set(newRadius) {
                if(newRadius > 0){
                    radius = newRadius
                } else{
                    console.log("Incorrect value.")
                }
            },
        },
        pi: {
            configurable: false,
            get() {
                return [3.14, 3.14159, 3.1415926536]
            },
        },
    })

    this.area = function(){
        let areaResults = []
        let circleArea
        this.pi.forEach(element => {
            circleArea = element*(radius**2)
            areaResults.push(circleArea)
        });
        return areaResults
    }

    this.perimeter = function(){
        let perimeterResults = []
        let circlePerimeter
        this.pi.forEach(element => {
            circlePerimeter = 2*element*radius
            perimeterResults.push(circlePerimeter)
        });
        return perimeterResults
    }

    this.printResults = function(){
        console.log("CIRCLE AREA ==========>")
        this.area().forEach(element => {
            this.area()
            console.log(element)
        });
        console.log("CIRCLE PERIMETER ========>")
        this.perimeter().forEach(element => {
            this.perimeter()
            console.log(element)
        });
    }
}

const circle1 = new Circle(5)
console.log(circle1.radius)
console.log(circle1.pi)

circle1.printResults()

console.log(circle1.radius)
delete circle1.radius
console.log(circle1.radius)

console.log(circle1.pi)
delete  circle1.pi
console.log(circle1.pi)
