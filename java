// ================= FILTRO DE PRODUTOS =================
const filterButtons = document.querySelectorAll('.filter-btn');
const cards = document.querySelectorAll('.card');

filterButtons.forEach(btn => {
  btn.addEventListener('click', () => {
    filterButtons.forEach(b => b.classList.remove('active'));
    btn.classList.add('active');

    const filter = btn.getAttribute('data-filter');

    cards.forEach(card => {
      if(filter === 'all') {
        card.style.display = 'flex';
      } else if(card.classList.contains(filter)) {
        card.style.display = 'flex';
      } else {
        card.style.display = 'none';
      }
    });
  });
});

// ================= CARROSSEL DE DEPOIMENTOS =================
const testimonialItems = document.querySelectorAll('.testimonial-item');
let testimonialIndex = 0;

function nextTestimonial() {
  testimonialItems[testimonialIndex].classList.remove('active');
  testimonialIndex = (testimonialIndex + 1) % testimonialItems.length;
  testimonialItems[testimonialIndex].classList.add('active');
}
setInterval(nextTestimonial, 6000);

