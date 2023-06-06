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
    edit(element){
        var container = document.getElementById(element)
        var inputElements = container.querySelectorAll('input')

        for (let index = 0; index < inputElements.length; index++) {
            inputElements[index].disabled = false;            
        }
    }
}