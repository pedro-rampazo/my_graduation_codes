const Modal = {
    open(element){
        document
            .querySelector(element)
            .classList
            .add('active')
    },
    close(element){
        document
            .querySelector(element)
            .classList
            .remove('active')
    },
    openNewHunch(element){
        Modal.open(element)

        Storage.getPlayers().forEach(DOM.createOption)
    },
}

const Behavior = {
    edit(element){
        var container = document.getElementById(element)
        var inputElements = container.querySelectorAll('input')
        var selectElements = container.querySelector('select')

        for (let index = 0; index < inputElements.length; index++) {
            inputElements[index].disabled = false           
        }

        selectElements.disabled = false
    }
}

const Storage = {
    getAll(){
        return JSON.parse(localStorage.getItem("golden_piggy:matches")) || []
    },
    getIndex(index){
        return JSON.parse(localStorage.getItem("golden_piggy:matches"))[index] || []
    },
    getPlayers(){
        return JSON.parse(localStorage.getItem("golden_piggy:players")) || []
    },
    set(hunches) {
        localStorage.setItem("golden_piggy:matches", JSON.stringify(hunches))
    }
}

const DOM = {
    hunchSection: document.querySelector('#hunch-section'),
    playerSelect: document.querySelector('#player-hunch'),

    createOption(player, index){
        var option = document.createElement('option')
        option.value = index
        option.textContent = player.name
        option.dataset.index = index
        DOM.playerSelect.appendChild(option)
    }
}

const Hunch = {
    all: Storage.getAll(),

    changeMatch(index) {
        // const homeTeamEmblem = document.getElementsByName('hmtm-emblem')[0]
        // const awayTeamEmblem = document.getElementsByName('awtm-emblem')[0]
        const matchObj = Storage.getIndex(index)
        document.getElementsByName('hmtm-name')[0].textContent = matchObj.homeTeam
        document.getElementsByName('awtm-name')[0].textContent = matchObj.awayTeam
        document.getElementsByName('hmtmgl-text')[0].textContent = matchObj.homeTeamGoals
        document.getElementsByName('awtmgl-text')[0].textContent = awayTeamGoals = matchObj.awayTeamGoals
    }
}

const App = {
    init(){
        const urlParams = new URLSearchParams(window.location.search)
        const index = urlParams.get('index')
        Hunch.changeMatch(index)
    }
}

App.init()