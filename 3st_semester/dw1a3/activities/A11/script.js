function getAdvice() {
    fetch('https://api.adviceslip.com/advice')
      .then(response => response.json())
      .then(data => {
        const { advice } = data.slip;
        document.getElementById('advice').textContent = advice
      })
      .catch(error => {
        console.log('Ocorreu um erro:', error);
      });
} 
  