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
        var inputElement = document.getElementById(element);
        inputElement.disabled = false;
    }
}