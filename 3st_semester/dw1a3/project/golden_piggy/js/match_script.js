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
    },
    restoreNwHuModalOverlay(){
        // document.getElementsById('player-hunch').value = ''
        document.getElementsByName('hmtmgls-input')[0].value = ''
        document.getElementsByName('awtmgls-input')[0].value = ''
        Modal.close('#nwhu-modal-overlay')
    },
}

const Storage = {
    getAll(){
        return JSON.parse(localStorage.getItem("golden_piggy:matches")) || []
    },
    getIndex(index){
        return JSON.parse(localStorage.getItem("golden_piggy:matches"))[index] || []
    },
    getIdMatch(){
        const urlParams = new URLSearchParams(window.location.search)
        return urlParams.get('index')
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
        option.value = player.name
        option.textContent = player.name
        option.dataset.index = index
        DOM.playerSelect.appendChild(option)
    },
    clearOption(){
        while (DOM.playerSelect.options.length > 0) {
            DOM.playerSelect.remove(0)
        }
    }
}

const Hunch = {
    all: Storage.getAll(),

    add(){
        const plHuSelect = document.getElementById('player-hunch').value
        const hmTmGls = document.getElementsByName('hmtmgls-input')[0].value
        const awTmGls = document.getElementsByName('awtmgls-input')[0].value
        const points = Hunch.getHunchPoints(Storage.getIdMatch(), hmTmGls, awTmGls)

        let {
            player,
            homeTeamGoals,
            awayTeamGoals,
            score
        } = {
            player: plHuSelect,
            homeTeamGoals: hmTmGls,
            awayTeamGoals: awTmGls,
            score: points
        }

        const hunchList = Storage.getIndex(Storage.getIdMatch()).hunches

        hunchList.push({player, homeTeamGoals, awayTeamGoals, score})

        console.log(hunchList)

        Behavior.restoreNwHuModalOverlay()
        App.reload()

    },
    changeMatch(index) {
        // const homeTeamEmblem = document.getElementsByName('hmtm-emblem')[0]
        // const awayTeamEmblem = document.getElementsByName('awtm-emblem')[0]
        const matchObj = Storage.getIndex(index)
        document.getElementsByName('hmtm-name')[0].textContent = matchObj.homeTeam
        document.getElementsByName('awtm-name')[0].textContent = matchObj.awayTeam
        document.getElementsByName('hmtmgl-text')[0].textContent = matchObj.homeTeamGoals
        document.getElementsByName('awtmgl-text')[0].textContent = awayTeamGoals = matchObj.awayTeamGoals
    },
    getHunchPoints(indexMatch, hmTmHuGoals, awTmHuGoals){
        const hmTmMaGoals = Storage.getIndex(indexMatch).homeTeamGoals
        const awTmMaGoals = Storage.getIndex(indexMatch).awayTeamGoals

        if(hmTmMaGoals == hmTmHuGoals && awTmMaGoals == awTmHuGoals) {
            return 10
        } else if(((hmTmMaGoals == hmTmHuGoals && awTmMaGoals != awTmHuGoals) || (hmTmMaGoals != hmTmHuGoals && awTmMaGoals == awTmHuGoals)) 
                    && 
                ((hmTmMaGoals > awTmMaGoals && hmTmHuGoals > awTmHuGoals) || (awTmMaGoals > hmTmMaGoals && awTmHuGoals > hmTmHuGoals))) 
        {
            return 7
        } else if((((hmTmMaGoals != hmTmHuGoals && awTmMaGoals != awTmHuGoals) && ((hmTmMaGoals > awTmMaGoals && hmTmHuGoals > awTmHuGoals) 
                    || 
                (awTmMaGoals > hmTmMaGoals && awTmHuGoals > hmTmHuGoals))) 
                    || 
                ((hmTmMaGoals == awTmMaGoals && hmTmHuGoals == awTmHuGoals) && (hmTmMaGoals != hmTmHuGoals && awTmMaGoals != awTmHuGoals))) ) 
        {
            return 5
        } else if((hmTmMaGoals == hmTmHuGoals && awTmMaGoals != awTmHuGoals) || (hmTmMaGoals != hmTmHuGoals && awTmMaGoals == awTmHuGoals)) 
        {
            return 2
        }
        return 0
    },
}

const App = {
    init(){
        Storage.set(Hunch.all)
        const index = Storage.getIdMatch()
        Hunch.changeMatch(index)
    },
    reload(){
        DOM.clearOption()
        App.init()
    },
}

App.init()