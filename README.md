# Web приложение для вебинаров (webinar-system)
Фунционал:
1. Расписание вебинаров (CRUD, выгрузка в Гугл/Яндекс расписание)
2. Регистрация на участие (по email)
3. Для участников отображается список вопросов QA к вебинару, возможность его изменять (свои QA)
4. Админка для настройки всего, групповые операция загрузки/выгрузки в xlsx (вебинаров, статистики итд.)
5. Рассылка участникам напоминаний на email, подписка на уведомления о новых вопросах, изменения в расписании, новых вебинарах...
6. Интеграция с Telegram (можно зававать через него QA, регистрировать, смотреть где участвуешь, получать напоминания и настройки )
7. Перезентация на базе собранных QA к вебинару для спикера

Технологии:
- Maven
- Java 21
- Spring Boot 3

Архитектура:
- многомодульный монолит
