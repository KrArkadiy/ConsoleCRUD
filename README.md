# DataStorerApp

Передо мной стояла задача по реализации консольного CRUD приложения, которое имеет следующие сущности:
<p>Writer(id, name, List<Post> posts)</p>
<p>Post(id, content, Long created, Long updated, List<Label> labels)</p>
<p>Label(id, name)</p>
<p>PostStatus (enum ACTIVE, DELETED)</p>
<hr>

Слои:
<p>model - POJO классы</p>
<p>repository - классы, реализующие доступ к текстовым файлам</p>
<p>controller - обработка запросов от пользователя</p>
<p>view - все данные, необходимые для работы с консолью</p>

<hr>
Требования к приложению:
<ol>
  <li>В качестве хранилища данных необходимо использовать текстовые файлы в формате JSON</li>
  <li>Пользователь в консоли должен иметь возможность создания, получения, редактирования и удаления данных</li>
  <li>Для работы с JSON файлами необходимо использовать библиотеку Gson</li>
</ol>

<hr>

Технологии: JavaSE8, Gson, Maven.
