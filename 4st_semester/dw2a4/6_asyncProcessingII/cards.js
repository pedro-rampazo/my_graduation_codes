async function getCards() {
    try {
        const response = await 
            fetch("https://www.deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1")

        if (response.status >= 200 && response.status < 300) {
            responseJSON = await response.json()
            document.getElementById("paragraph").innerHTML = "getCards Success!"
            return responseJSON
        } else {
            throw new Error(responseJSON.deck_id, responseJSON.remaining)
        }
    } catch (error) {
        document.getElementById("paragraph").innerHTML = error
    }
}

async function drawCards() {
    try {
        const cards = await getCards()
        const response = await 
            fetch("https://www.deckofcardsapi.com/api/deck/" + cards.deck_id + "/draw/?count=4")
        
        if (response.status >= 200 && response.status < 300) {
            responseJSON = await response.json()
            return responseJSON
        } else {
            throw new Error(responseJSON.deck_id, responseJSON.remaining)
        }
    } catch (error) {
        document.getElementById("paragraph").innerHTML = error
    }
}

async function displayCards() {
    try {
        const fourCards = await drawCards()
        const cardOne = document.getElementById("card#01")
        const cardTwo = document.getElementById("card#02")
        const cardThree = document.getElementById("card#03")
        const cardFour = document.getElementById("card#04")
        cardOne.src = fourCards.cards[0].image
        cardTwo.src = fourCards.cards[1].image
        cardThree.src = fourCards.cards[2].image
        cardFour.src = fourCards.cards[3].image
    } catch (error) {
        document.getElementById("paragraph").innerHTML = error
    }
}