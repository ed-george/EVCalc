<?php


function etcalcOptionsPage()
{
    global $options_page;
?>
    <div class="wrap">
        <h1>
            <?php
            echo __('ETCalc Settings', 'etcalc');
            ?>
        </h1>
        <form method="POST" enctype="multipart/form-data" action="options.php">
            <?php
            settings_fields('etcalcOptions');
            do_settings_sections($options_page);
            ?>
            <p class="submit">
                <input type="submit" class="button-primary" value="<?php _e('Save changes', 'etcalc') ?>" />
            </p>
        </form>
    </div>
<?php
}

function etcalcOptionsSettings()
{
    global $options_page;
    // Присваиваем функцию валидации
    register_setting('etcalcOptions', 'etcalcOptions', 'etcalcValidateSettings');

    // Добавляем секцию
    add_settings_section('etcalc_main_section', __('Main settings', 'etcalc'), '', $options_page);

    // Текстовое поле для ключа API
    $apiKeyFieldParams = array(
        'type'      => 'text', // Тип
        'id'        => 'api_key',
        'desc'      => __('Write here your API key, obtained from Dynamium Admin.', 'etcalc'), // Описание
        'label_for' => 'api_key' 
    );
    add_settings_field('api_key_field', __('API Key', 'etcalc'), 'etcalcOptionsDisplaySettings', $options_page, 'etcalc_main_section', $apiKeyFieldParams); // Добавить поле
}
add_action('admin_init', 'etcalcOptionsSettings');

/*
 * Функция отображения полей ввода
 * Здесь задаётся HTML и PHP, выводящий поля
 */
function etcalcOptionsDisplaySettings($args)
{
    extract($args);

    $option_name = 'etcalcOptions';

    $o = get_option($option_name);

    switch ($type) {
        case 'text':
            $o[$id] = esc_attr(stripslashes($o[$id]));
            echo "<input class='regular-text' type='text' id='$id' name='" . $option_name . "[$id]' value='$o[$id]' />";
            echo ($desc != '') ? "<br /><span class='description'>$desc</span>" : "";
            break;
        case 'textarea':
            $o[$id] = esc_attr(stripslashes($o[$id]));
            echo "<textarea class='code large-text' cols='50' rows='10' type='text' id='$id' name='" . $option_name . "[$id]'>$o[$id]</textarea>";
            echo ($desc != '') ? "<br /><span class='description'>$desc</span>" : "";
            break;
        case 'checkbox':
            $checked = ($o[$id] == 'on') ? " checked='checked'" :  '';
            echo "<label><input type='checkbox' id='$id' name='" . $option_name . "[$id]' $checked /> ";
            echo ($desc != '') ? $desc : "";
            echo "</label>";
            break;
        case 'select':
            echo "<select id='$id' name='" . $option_name . "[$id]'>";
            foreach ($vals as $v => $l) {
                $selected = ($o[$id] == $v) ? "selected='selected'" : '';
                echo "<option value='$v' $selected>$l</option>";
            }
            echo ($desc != '') ? $desc : "";
            echo "</select>";
            break;
        case 'radio':
            echo "<fieldset>";
            foreach ($vals as $v => $l) {
                $checked = ($o[$id] == $v) ? "checked='checked'" : '';
                echo "<label><input type='radio' name='" . $option_name . "[$id]' value='$v' $checked />$l</label><br />";
            }
            echo "</fieldset>";
            break;
    }
}

/*
 * Функция проверки правильности вводимых полей
 */
function etcalcValidateSettings($input)
{
    foreach ($input as $k => $v) {
        $valid_input[$k] = trim($v);

        /* Вы можете включить в эту функцию различные проверки значений, например
		if(! задаем условие ) { // если не выполняется
			$valid_input[$k] = ''; // тогда присваиваем значению пустую строку
		}
		*/
    }
    return $valid_input;
}
