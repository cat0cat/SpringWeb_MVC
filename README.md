# Домашнее задание к занятию «2.3. Spring Web MVC»

## Данные не удаляются*

**Важно**: данная задача не является обязательной

### Легенда

Самое плохое, что можно сделать с пользовательскими данными - это безвозвратно их удалить (они потом всегда звонят с просьбой восстановить и утверждают, что они-то точно ничего сами не удаляли). Поэтому чаще всего их не удаляют, а помечают на удаление (т.е. добавляют какое-то поле, например, `removed`).

Для простоты мы будем считать, что `/api/posts` - это API для клиентов, где они не смогут реализовать "восстановление" удалённых постов и даже просмотреть удалённые посты. Для этого будет отдельное API (позже).

Соответственно, получается, что `removeById` всего лишь выставляет это поле. Но это не всё, работа остальных методов тоже кардинально меняется:
* `all` возвращает все посты, кроме тех, у которых выставлен флаг `removed`
* `getById` возвращает пост только если у него не выставлен флаг `removed`, в противном случае кидает `NotFoundException`*
* `save` обновляет существующий пост только если у него не выставлен флаг `removed`, в противном случае кидает `NotFoundException`*

Примечание*: здесь нет идеального решения, разные люди могут вам говорить, что так можно, так нельзя и т.д. Мы же лишь скажем, что любая категоричность - это всегда плохо и вы должны понимать, что бывает по-разному, всё зависит от того, какое решение примет проектировщик API или команда.

Единственный вопрос остаётся со статус кодами. По логике, `NotFoundException` должен приводить к статус коду 404. Изучите документацию на [@ResponseStatus](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseStatus.html) и подумайте, как её применить для выставления статуса кода 404 при возникновении указанного нами Exception'а.

<details>
<summary>Подсказка</summary>

Использовать её нужно в формате `@ResponseStatus(code = HttpStatus.NOT_FOUND)`, при этом, конечно же, импортировать и `ResponseStatus` и `HttpStatus`.
</details>

### Задача

Создайте Pull Request с описанной функциональностью к проекту из первой задачи (Migration).

Решение по тому, на каком именно слое реализовать данную логику - остаётся за вами. Скажем лишь, что это точно не Controller.

Обратите внимание, что вся функциональность (CRUD), реализованная до этого, должна по-прежнему работать.

### Результат

В качестве результата пришлите:
1. Ссылку на ваш Pull Request в личном кабинете студента на сайте [netology.ru](https://netology.ru)
1. Обоснование, почему вы реализовали логику именно в том слое, в котором реализовали