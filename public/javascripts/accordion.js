

/** The class of hidden elements in the accordion */
var accordionHiddenClass = "accordion-hidden";


/**
 * Closes all the accordion sections and displays
 * the section represented by the currentSelector
 */
function closeAndExpands(contentSelector){

  var currentContent = document.querySelector(contentSelector);

  if(!isHidden(currentContent)) {
    close(currentContent);
  }
  else {
    var i;
    var contents = document.querySelectorAll("#main-container section");
    for(i=0; i<contents.length; i++){
      close(contents[i]);
    }
    show(currentContent);
  }
}

/**
 * Tests if the current node is hidden or not.
 */
function isHidden(node) {
  return node.classList.contains(accordionHiddenClass);
}

/**
 * Closes the current node.
 */
function close(node){
  node.classList.add(accordionHiddenClass);
}

/**
 * Displays the current node.
 */
function show(node){
  node.classList.remove(accordionHiddenClass);
}
