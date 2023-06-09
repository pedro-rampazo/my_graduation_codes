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
    openEdit(index){
        let obj = Player.all[index]

        function restoreModal() {
            Behavior.restorePlModalOverlay(index)
        }

        document.getElementById('player-name-inpt').value = obj.name
        document.getElementById('point-label').textContent = obj.points
        document.getElementById('hit-label').textContent = obj.hits
        document.getElementById('close-icon').onclick = restoreModal

        Modal.open('#pl-modal-overlay')
    },
    confirmationValue(){
        
    },
}

const Behavior = {
    edit(element){
        var inputElement = document.getElementById(element);
        inputElement.disabled = false;
    },
    restoreNwPlModalOverlay(){
        document.getElementById('nwplnm-input').value = ''
        Modal.close('#nwpl-modal-overlay')
    },
    restorePlModalOverlay(index){
        Modal.close('#pl-modal-overlay')
        let obj = Player.all[index]
        
        document.getElementById('player-name-inpt').value = obj.name
        document.getElementById('player-name-inpt').disabled = true
        
    }
}

const Storage = {
    get() {
        return JSON.parse(localStorage.getItem("golden_piggy:players")) || []
    },
    set(players) {
        localStorage.setItem("golden_piggy:players", JSON.stringify(players))
    }
}

const DOM = {
    mainContainer: document.querySelector('#pl-section'),

    addPlayer(player, index) {
        
        function openModal() {
            Modal.openEdit(index)
        }
        
        const sec = document.createElement('section')
        sec.classList.add('player')
        sec.innerHTML = `<h4>${player.name}</h4>
                        <img src="../images/arrow_icon.svg" alt="View">`
        sec.dataset.index = index

        sec.onclick = openModal

        DOM.mainContainer.appendChild(sec)
    },

    clearPlayers() {
        DOM.mainContainer.innerHTML = ''
    }
}

const Player = {
    all: Storage.get(),

    add() {
        const nwPlNmInput = document.getElementById('nwplnm-input').value
        let {name, points, hits, position} = {name: nwPlNmInput, points: 0, hits: 0, position: null}

        Player.all.push({name, points, hits, position})
        App.reload()
    }
}

const App = {
    init() {
        Player.all.forEach(DOM.addPlayer)

        Storage.set(Player.all)
    },
    reload() {
        document.getElementById('nwplnm-input').value = ''
        Modal.close('#nwpl-modal-overlay')
        DOM.clearPlayers()
        App.init()
    }
}

App.init()