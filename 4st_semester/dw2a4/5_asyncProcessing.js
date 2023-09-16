function timeRandom(min, max) {
    return Math.floor(Math.random() * (max - min) + min)
}

function connectDatabase(database) {
    return new Promise((resolve, reject) => {
        if (database === "mysql") {
            setTimeout(() => {
                resolve("Connecting Database... Done!")
            }, timeRandom(1, 5) * 1000)
        } else {
            reject("Failed to load database")
        }
    })
}

function searchData(fruit) {
    const fruits = ["Grape", "Banana", "Lemon", "Strawberry", "Watermelon"]
    return new Promise((resolve, reject) => {
        if (fruits.includes(fruit)) {
            setTimeout(() => {
                resolve("Row(s) affected to: " + fruit)
            }, timeRandom(1, 5) * 1000)
        } else {
            reject("0 Row(s) affected")
        }
    })
}

function updateTable(tableName) {
    return new Promise((resolve, reject) => {
        if (tableName === "fruit") {
            setTimeout(() => {
                resolve("The FRUIT table was updated successfully!")
            }, timeRandom(1, 5) * 1000)
        } else {
            reject("Error updating the FRUIT table")
        }
    })
}

function executeDatabaseRoutine() {
    connectDatabase("mysql")
        .then(
            answer => {
                console.log("Success! " + answer)
                return searchData("Strawberry")
            },
            answer => {
                console.log("Error! " + answer)
            }
        )
        .then(
            answer => {
                console.log(answer)
                return updateTable("fruit")
            },
            answer => {
                console.log(answer)
            }
        )
        .then(
            answer => {
                console.log(answer)
            },
            answer => {
                console.log(answer)
            }
        )
}

async function executeDatabaseRoutineAsync() {
    try {
        const answr1 = await connectDatabase("mysql")
        console.log(answr1)
        const answr2 = await searchData("Watermelon")
        console.log(answr2)
        const answr3 = await updateTable("fruit")
        console.log(answr3)
    } catch(exception) {
        console.log(exception)
    }
}

executeDatabaseRoutine()
executeDatabaseRoutineAsync()
