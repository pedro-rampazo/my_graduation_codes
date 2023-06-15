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
    openEditMatch(){
        let obj = Hunch.all[Storage.getIdMatch()]

        document.getElementById('hmtm-name').value = obj.homeTeam
        document.getElementsByName('hmtm-goals')[0].value = obj.homeTeamGoals
        document.getElementsByName('awtm-goals')[0].value = obj.awayTeamGoals
        document.getElementById('awtm-name').value = obj.awayTeam
        document.getElementsByName('date')[0].value = obj.date
        document.getElementsByName('time')[0].value = obj.time
        document.getElementsByName('stadium')[0].value = obj.stadium
        document.getElementsByName('championship')[0].value = obj.championship
        document.getElementsByName('transmission')[0].value = obj.transmission

        Modal.open('#ma-modal-overlay')
    },
    updateConfirmationMaModal(){
        var yesBttn = document.getElementById('yes-bttn')
        var noBttn = document.getElementById('no-bttn')

        yesBttn.onclick = function() {
            Hunch.updateMatch(Storage.getIdMatch())
            Modal.close('#confirmation-modal-overlay')
            Modal.close('#ma-modal-overlay')
            App.reload()
        }

        noBttn.onclick = function() {
            Modal.close('#confirmation-modal-overlay')
        }

        Modal.open('#confirmation-modal-overlay')
    },
}

const Behavior = {
    edit(element, boolValue){
        var container = document.getElementById(element)
        var inputElements = container.querySelectorAll('input')
        var selectElements = container.querySelector('select')

        for (let index = 0; index < inputElements.length; index++) {
            inputElements[index].disabled = boolValue         
        }

        selectElements.disabled = boolValue
    },
    restoreNwHuModalOverlay(){
        // document.getElementsById('player-hunch').value = ''
        document.getElementsByName('hmtmgls-input')[0].value = ''
        document.getElementsByName('awtmgls-input')[0].value = ''
        Modal.close('#nwhu-modal-overlay')
    },
    restoreMaModalOverlay(){
        Modal.close('#ma-modal-overlay')
        Behavior.edit('ma-modal', true)
    }
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
    },
    addHunch(hunch, index) {
        const section = document.createElement('section')
        section.id = 'hunch'
        section.onclick = function() {
            Modal.open('#hu-modal-overlay')
        }
        section.innerHTML = `
        <div class="hunch-cell">
            <h4>${hunch.player}</h4>
        </div>
        <div class="hunch-cell">
            <h4>${hunch.homeTeamGoals} X ${hunch.awayTeamGoals}</h4>
        </div>
        <div class="hunch-cell">
            <h4>+${hunch.score}</h4>
            <img src="../images/arrow_icon.svg" alt="Click">
        </div>
        `
        section.dataset.index = index
        DOM.hunchSection.appendChild(section)
    },
    clearHunch(){
        DOM.hunchSection.innerHTML = ''
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

        Hunch.all[Storage.getIdMatch()].hunches.push({player, homeTeamGoals, awayTeamGoals, score})

        Behavior.restoreNwHuModalOverlay()
        App.reload()
    },
    changeMatch(index) {
        const matchObj = Storage.getIndex(index)

        document.getElementsByName('hmtm-name')[0].textContent = matchObj.homeTeam
        document.getElementsByName('awtm-name')[0].textContent = matchObj.awayTeam
        document.getElementsByName('hmtmgl-text')[0].textContent = matchObj.homeTeamGoals
        document.getElementsByName('awtmgl-text')[0].textContent = awayTeamGoals = matchObj.awayTeamGoals

        switch (matchObj.homeTeam) {
            case 'São Paulo':
                document.getElementById('hmtm-emblem').src = '../images/sao_paulo.svg'
                break;
            case 'Bahia':
                document.getElementById('hmtm-emblem').src = '../images/bahia.svg'
                break;
            default:
                document.getElementById('hmtm-emblem').src = '../images/palmeiras.svg'
                break;
        }

        switch (matchObj.awayTeam) {
            case 'São Paulo':
                document.getElementById('awtm-emblem').src = '../images/sao_paulo.svg'
                break;
            case 'Bahia':
                document.getElementById('awtm-emblem').src = '../images/bahia.svg'
                break;
            default:
                document.getElementById('awtm-emblem').src = '../images/palmeiras.svg'
                break;
        }
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
    updateMatch(index){
        let {
            homeTeam, 
            homeTeamGoals, 
            awayTeam, 
            awayTeamGoals, 
            date, 
            time, 
            stadium, 
            championship, 
            transmission,
            hunches
        } = {
            homeTeam: document.getElementById('hmtm-name').value,
            homeTeamGoals: document.getElementsByName('hmtm-goals')[0].value,
            awayTeam: document.getElementById('awtm-name').value,
            awayTeamGoals: document.getElementsByName('awtm-goals')[0].value,
            date: document.getElementsByName('date')[0].value,
            time: document.getElementsByName('time')[0].value,
            stadium: document.getElementsByName('stadium')[0].value,
            championship: document.getElementsByName('championship')[0].value,
            transmission: document.getElementsByName('transmission')[0].value,
            hunches: Hunch.all[index].hunches
        }

        Hunch.all[index] = {homeTeam, homeTeamGoals, awayTeam, awayTeamGoals, 
            date, time, stadium, championship, transmission, hunches}

    },
}

const App = {
    init(){
        Hunch.all[Storage.getIdMatch()].hunches.forEach(DOM.addHunch)
        Storage.set(Hunch.all)
        const index = Storage.getIdMatch()
        Hunch.changeMatch(index)
    },
    reload(){
        DOM.clearOption()
        DOM.clearHunch()
        App.init()
    },
}

App.init()