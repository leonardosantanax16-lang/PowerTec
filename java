// ================= FILTRO PREMIUM =================
const filterButtons = document.querySelectorAll('.filter-btn');
const sections = document.querySelectorAll('[data-section]');

filterButtons.forEach(btn => {
  btn.addEventListener('click', () => {
    filterButtons.forEach(b => b.classList.remove('active'));
    btn.classList.add('active');

    const filter = btn.dataset.filter;

    sections.forEach(section => {
      if (filter === 'all' || section.dataset.section === filter) {
        section.style.display = 'grid';
      } else {
        section.style.display = 'none';
      }
    });

    window.scrollTo({ top: 0, behavior: 'smooth' });
  });
});

// ================= FORMULÁRIO → WHATSAPP =================
document.getElementById('tradeForm').addEventListener('submit', e => {
  e.preventDefault();

  const fields = [...e.target.elements].filter(el => el.value);
  let message = 'Avaliação de iPhone:%0A';

  fields.forEach(el => {
    message += `• ${el.placeholder || el.previousElementSibling?.innerText}: ${el.value}%0A`;
  });

  window.open(`https://wa.me/5511999999999?text=${message}`, '_blank');
});

// ================= CARROSSEL DE DEPOIMENTOS =================
const testimonials = document.querySelectorAll('.testimonial-item');
let index = 0;

setInterval(() => {
  testimonials[index].classList.remove('active');
  index = (index + 1) % testimonials.length;
  testimonials[index].classList.add('active');
}, 6000);
