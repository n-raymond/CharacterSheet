


function glassFolding(pokemon_box){
  var currentAttacksFolder = document.querySelector("#" + pokemon_box + " .pokemon_attacks_folding");

  if(currentAttacksFolder.classList.contains("down")){
    currentAttacksFolder.classList.remove("down");
  }
  else{
    currentAttacksFolder.classList.add("down");
  }
}
