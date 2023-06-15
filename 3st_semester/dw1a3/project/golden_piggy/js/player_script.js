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
        
        document.getElementById('save-bttn').onclick = function () {
            Modal.updateConfirmation(index)
        }
        
        document.getElementById('delete-bttn').onclick = function() {
            Modal.removeConfirmation(index)
        }

        Modal.open('#pl-modal-overlay')
    },
    removeConfirmation(index){
        var yesBttn = document.getElementById('yes-bttn')
        var noBttn = document.getElementById('no-bttn')
        Modal.open('#confirmation-modal-overlay')
        yesBttn.onclick = function() {
            Player.remove(index)
            Modal.close('#confirmation-modal-overlay')
            Modal.close('#pl-modal-overlay')
            App.reload()
        }
        noBttn.onclick = function() {
            Modal.close('#confirmation-modal-overlay')
        }
    },
    updateConfirmation(index){
        var yesBttn = document.getElementById('yes-bttn')
        var noBttn = document.getElementById('no-bttn')
        
        yesBttn.onclick = function() {
            Player.update(index)
            Modal.close('#confirmation-modal-overlay')
            Modal.close('#pl-modal-overlay')
            App.reload()
        }

        noBttn.onclick = function() {
            Modal.close('#confirmation-modal-overlay')   
        }

        Modal.open('#confirmation-modal-overlay')
    },
}

const Behavior = {
    edit(element, bool_value){
        var inputElement = document.getElementById(element);
        inputElement.disabled = bool_value;
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
        Behavior.restoreNwPlModalOverlay()
        App.reload()
    },
    remove(index){
        Player.all.splice(index, 1)
    },
    update(index){
        const newValue = document.getElementById('player-name-inpt').value
        Player.all[index].name = newValue
    },
}

const App = {
    init() {
        Player.all.forEach(DOM.addPlayer)
        Storage.set(Player.all)
    },
    reload() {
        DOM.clearPlayers()
        App.init()
    }
}

App.init()