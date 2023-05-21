function resize(){
    var results = document.querySelectorAll(".size-value")
    var new_width = results[0].value
    var new_height = results[1].value
    document.getElementById("container").style.width = new_width + "px"
    document.getElementById("container").style.height = new_height + "px"
    document.querySelector("h2").textContent = new_width + "X" + new_height
}
