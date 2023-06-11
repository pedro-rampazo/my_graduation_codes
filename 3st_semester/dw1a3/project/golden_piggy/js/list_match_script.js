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
    }
}

const Behavior = {
    restoreNwMtModalOverlay(){
        document.getElementsByName('hmtm-input')[0].value = ''
        document.getElementsByName('awtm-input')[0].value = ''
        document.getElementsByName('hmtmgl-input')[0].value = ''
        document.getElementsByName('awtmgl-input')[0].value = ''
        document.getElementsByName('date')[0].value = ''
        document.getElementsByName('time')[0].value = ''
        document.getElementsByName('stadium-input')[0].value = ''
        document.getElementsByName('championship-input')[0].value = ''
        document.getElementsByName('transmission-input')[0].value = ''
        Modal.close('#nwma-modal-overlay')
    }
}

const Storage = {
    get() {
        return JSON.parse(localStorage.getItem("golden_piggy:matches")) || []
    },
    set(matches) {
        localStorage.setItem("golden_piggy:matches", JSON.stringify(matches))
    }
}

const DOM = {
    mainContainer: document.querySelector('#ma-section'),

    addMatch(match, index) {
        const link = document.createElement('a')
        link.href = "../html/match.html"
        link.innerHTML = `
        <section class="match">
            <h4 class="match-label">${match.homeTeam} X ${match.awayTeam}</h4>
            <h4>${match.date}</h4>
            <img src="../images/arrow_icon.svg" alt="View">
        </section>
        `
        link.dataset.index = index

        DOM.mainContainer.appendChild(link)
    },
    clearMatches(){
        DOM.mainContainer.innerHTML = ''
    }
}

const Match = {
    all: Storage.get(),

    add(){
        const nwHmTmInput = document.getElementsByName('hmtm-input')[0].value
        const nwAwTmInput = document.getElementsByName('awtm-input')[0].value
        const nwHmTmGlInput = document.getElementsByName('hmtmgl-input')[0].value
        const nwAwTmGlInput = document.getElementsByName('awtmgl-input')[0].value
        const nwDateInput = document.getElementsByName('date')[0].value
        const nwTimeInput = document.getElementsByName('time')[0].value
        const nwStadiumInput = document.getElementsByName('stadium-input')[0].value
        const nwChampionshipInput = document.getElementsByName('championship-input')[0].value
        const nwTransmissionInput = document.getElementsByName('transmission-input')[0].value

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
            homeTeam: nwHmTmInput,
            homeTeamGoals: nwHmTmGlInput,
            awayTeam: nwAwTmInput,
            awayTeamGoals: nwAwTmGlInput,
            date: nwDateInput,
            time: nwTimeInput,
            stadium: nwStadiumInput,
            championship: nwChampionshipInput,
            transmission: nwTransmissionInput,
            hunches: []
        }

        Match.all.push({
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
        })
    
        Behavior.restoreNwMtModalOverlay()
        App.reload()
    },
}

const App = {
    init() {
        Match.all.forEach(DOM.addMatch)
        Storage.set(Match.all)
    },
    reload() {
        DOM.clearMatches()
        App.init()
    },
}

App.init()