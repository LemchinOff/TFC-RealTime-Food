<div align="center">

<img src="src/main/resources/icon.png" alt="TFC Real-Time Food Expiry Logo" width="160" style="border-radius: 16px;" />

# TFC Real-Time Food Expiry

**Convert TerraFirmaCraft food expiration time into real-world hours, minutes, and seconds**

**Перевод срока годности еды из TerraFirmaCraft в реальные часы, минуты и секунды**

<p>
  <a href="#english"><b>🇬🇧 English</b></a> •
  <a href="#русский"><b>🇷🇺 Русский</b></a>
</p>

<p>
  <a href="https://modrinth.com">
    <img src="https://shields.io" alt="Modrinth" />
  </a>
  <a href="https://www.curseforge.com/minecraft/mc-mods/tfc-realtime-food">
    <img src="https://shields.io" alt="CurseForge" />
  </a>
  <a href="[https://github.com](https://github.com/LemchinOff/TFC-RealTime-Food)">
    <img src="https://shields.io" alt="GitHub Releases" />
  </a>
</p>

<p>
  <a href="https://github.com/latest">
    <img src="https://shields.io" alt="Release" />
  </a>
  <img src="https://shields.io" alt="Minecraft 1.20.1 Forge" />
  <img src="https://shields.io" alt="Client Only" />
  <a href="LICENSE.txt">
    <img src="https://shields.io" alt="License MIT" />
  </a>
</p>

</p>

</div>

---

<h2 id="english">🇬🇧 Start here</h2>

| I want to... | Open |
| :--- | :--- |
| Download the mod | **[GitHub Releases](https://github.com/latest)** / **[Modrinth](https://modrinth.com)** / **[CurseForge](ССЫЛКА_НА_CURSEFORGE)** |
| See how it works in-game | **[Features & Comparison](#features)** |
| Report a bug or suggest an idea | **[GitHub Issues](https://github.com/LemchinOff/TFC-RealTime-Food/issues)** |

### ✨ Features

* ⏱️ **Real-Time Conversion:** Replaces the in-game duration inside tooltip brackets (e.g. `(In 8 days)` → `(2 h 40 m)`) while keeping the exact TFC calendar expiration date intact.
* 🔍 **Full Jade Integration:** Works seamlessly both in your inventory and when looking at ceramic vessels, food shelves, barrels, or cellars via **Jade**.
* ⌨️ **Instant Hotkey Toggle:** Press **`H`** (customizable in *Controls*) at any time — **even with an open inventory or chest** — to silently toggle between real-world time and standard TFC calendar time.
* 💾 **Persistent Config:** Automatically saves your selected toggle state (`config/tfcrealtimefood-client.toml`) across game restarts.
* 🌍 **Language Independent:** Parses internal TFC time components directly rather than text strings, working on any Minecraft language (`en_us` and `ru_ru` included).

### 📊 How It Looks In-Game

| Display Mode | Tooltip Example |
| :--- | :--- |
| **Default TFC** | `Edible until: 17:53 May 1, 1012 (In 8 days)` |
| **Real-Time Mode (`H`)** | `Edible until: 17:53 May 1, 1012 (2 h 40 m)` |

### 📦 Installation

1. Make sure you have **Minecraft 1.20.1**, **Forge**, and **TerraFirmaCraft** installed.
2. Drop `TFCRealTimeFood-x.x.x.jar` into your `mods` folder (no server installation required).
3. Launch the game and press **`H`** whenever you want to switch display modes!

---

<h2 id="русский">🇷🇺 Начните здесь</h2>

| Я хочу... | Открыть |
| :--- | :--- |
| Скачать мод | **[GitHub Releases](https://github.com/latest)** / **[Modrinth](https://modrinth.com)** / **[CurseForge](ССЫЛКА_НА_CURSEFORGE)** |
| Посмотреть возможности и примеры | **[Возможности и сравнение](#возможности)** |
| Сообщить об ошибке или предложить идею | **[GitHub Issues](https://github.com/LemchinOff/TFC-RealTime-Food/issues)** |

### ✨ Возможности

* ⏱️ **Пересчёт в реальное время:** Заменяет внутриигровую длительность внутри скобок (например, `(В течении 8 дней)` → `(В течении 2 ч. 40 мин.)`), сохраняя при этом точную календарную дату порчи TFC.
* 🔍 **Полная поддержка Jade:** Работает как в инвентаре, так и при наведении на керамические сосуды, полки для еды, бочки и погреба через **Jade**.
* ⌨️ **Мгновенное переключение клавишей:** Нажмите **`H`** (можно переназначить в *Настройках управления*) в любой момент — **даже при открытом инвентаре или сундуке** — чтобы бесшумно переключаться между реальным и игровым временем.
* 💾 **Автосохранение настроек:** Выбранный режим отображения автоматически сохраняется в файл `config/tfcrealtimefood-client.toml` при перезапуске игры.
* 🌍 **Независимость от языка:** Считывает внутренние компоненты времени TFC напрямую, поэтому работает на любом языке Minecraft (включает локализации `ru_ru` и `en_us`).

### 📊 Как это выглядит в игре

| Режим отображения | Пример подсказки |
| :--- | :--- |
| **Стандартный TFC** | `Съедобно до: 17:53 Май 1, 1012 (В течении 8 дней)` |
| **Реальное время (`H`)** | `Съедобно до: 17:53 Май 1, 1012 (В течении 2 ч. 40 мин.)` |

### 📦 Установка

1. Убедитесь, что у вас установлены **Minecraft 1.20.1**, **Forge** и **TerraFirmaCraft**.
2. Поместите файл `TFCRealTimeFood-x.x.x.jar` в папку `mods` (установка на сервер не требуется).
3. Запускайте игру и нажимайте **`H`**, чтобы переключать формат таймера!
