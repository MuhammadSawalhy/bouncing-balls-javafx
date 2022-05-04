<div dir=rtl>

# الكرات الواثبة

مشروع برمجة مطلوب من الكلية تدريبا على ما تعلمناه من الجافا وال javafx

# أمثلة وإلهامات

  1. https://codepen.io/rglazebrook/pen/AMMgVz
  2. https://www.youtube.com/watch?v=x6NFmzQHvMU
  3. https://www.youtube.com/watch?v=YIKRXl3wH8Y
  3. به محتوى متقدم قليلا، ربما يصعب على المبتدئين، لكن يمكنك أن تأخذ من فكرة عن اكتشاف التصادم بين الكرات والاطلاع على عالم رسومات الحاسوب المليئ computer graphics بالمغامرات والإثارة: https://www.youtube.com/watch?v=eED4bSkYCB8

# مخطط الواجهة

![مخطط الواجهة](./gui-sketch.png)

# مخطط الفئات Classes Diagram

- هذا المخطط مصمم ببرنامج [draw.io](https://draw.io)، وملف المشروع هو _./bouncing-balls-class-uml.svg_.
- ما هو باللون الأصفر سنأجله مؤقتا (وربما نتخلى عنه)، وهي خاصية اصطدام الكرات ببعضها.

![مخطط الفئات](./bouncing-balls-class-uml.svg)

# تقسم المهام

- الواجهة وربطها بالأحداث: App, SpeedSliderHandler, GravitationalEdgesCheckBoxHandler
  - محمود خالد
  - محمد بن أحمد بن نصر
- إنتاج الكرات: BallsGenerator, RandomColor, Ball, Vector
  - مؤمن العطار
  - محمد أشرف
  - محمد سمير الصنافين

- المتحكم: Controller, EdgesController, GravitationalEdgesController
  - محمد تامر
  - محمد ذكي
  - محمد علي عبد المحسن
  - محمد فتحي * 2


# الرخصة

<div dir=ltr>

```
Copyright 2022 Zagazig university students team (the names listed above)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
