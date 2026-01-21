const buttons = document.querySelectorAll('.filter-btn');
const sections = document.querySelectorAll('[data-section]');

buttons.forEach(btn => {
  btn.addEventListener('click', () => {
    buttons.forEach(b => b.classList.remove('active'));
    btn.classList.add('active');

    const filter = btn.dataset.filter;

    sections.forEach(section => {
      section.style.display =
        filter === 'all' || section.dataset.section === filter
          ? 'grid'
          : 'none';
    });

    window.scrollTo({ top: 0, behavior: 'smooth' });
  });
});

const tradeForm = document.getElementById('tradeForm');

if (tradeForm) {
  tradeForm.addEventListener('submit', e => {
    e.preventDefault();

    let msg = 'Avaliação de iPhone:\n';
    [...tradeForm.elements].forEach(el => {
      if (el.placeholder && el.value) {
        msg += `• ${el.placeholder}: ${el.value}\n`;
      }
    });

    window.open(
      `https://wa.me/5521967296969?text=${encodeURIComponent(msg)}`,
      '_blank'
    );
  });
}
