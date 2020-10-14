<?php
/*
 * Plugin Name: ETCalc
 * Description: Plugin for adding ETCalc functionality on your website.
 * Plugin URI:  https://dynamium.company/etcalc/wordpress
 * Author URI:  https://t.me/GGorAAOfficial
 * Author:      GGorAA
 * Version:     1.0-alpha1
 *
 * Text Domain: Идентификатор перевода, указывается в load_plugin_textdomain()
 * Domain Path: /languages
 *
 * License:     GPL2
 * License URI: https://www.gnu.org/licenses/gpl-2.0.html
 *
 * Network:     true
 */

include 'admin/etcalc-options.php'; // Подключаем файл с интерфейсом настроек

// Создание самой страницы настроек в настройках WordPress
add_action('admin_menu', 'etcalcOptions');
// Хук для включения переводов
add_action('after_setup_theme', 'etcalcLoadThemeTextdomain');

// Функция для включения переводов
function etcalcLoadThemeTextdomain()
{
    load_plugin_textdomain('etcalc', false, dirname(plugin_basename(__FILE__)) . '/languages/');
}

// Настройки страницы настроек
$options_page = 'etcalc-options.php';
function etcalcOptions()
{
    global $options_page;
    add_options_page('ETCalc', 'ETCalc', 'manage_options', $options_page, 'etcalcOptionsPage');
}

add_action('wp_enqueue_scripts', 'etcalcFrontend');
add_action('wp_footer', 'etcalcFrontendHtml');

function etcalcFrontend()
{
    wp_enqueue_script(
        'etcalc-frontend',
        WP_PLUGIN_URL . '/etcalc/js/etcalc.js',
        array('jquery'),
        '1.0',
        true
    );
    wp_enqueue_style(
        'etcalc-frontend',
        WP_PLUGIN_URL . '/etcalc/css/main.css',
        false
    );
}

function etcalcFrontendHtml()
{
?>
    <!--
    <div id="etcalc-window">
        <div id="etcalc-window-content">
            <div>
            <img src="<?php //echo WP_PLUGIN_URL 
                        ?>/etcalc/resources/close.svg" id="etcalc-close-button" class="etcalc-close-button">
                <h1 align="center" class="etcalc-heading" id="etcalc-heading">
                    <?php //echo __('What you want to calculate?', 'etcalc') 
                    ?>
                </h1>
                <div class="etcalc-button-wrapper">
                    <button id="etcalc-mileage" class="etcalc-button">
                        <span class="button-text">
                            <?php //echo __('Mileage', 'etcalc') 
                            ?>
                        </span>
                    </button>
                    <button id="etcalc-battery-consumption" class="etcalc-button">
                        <span class="etcalc-button-text">
                            <?php //echo __('Battery consumption rate', 'etcalc') 
                            ?>
                        </span>
                    </button>
                </div>
            </div>
        </div>
    </div>--->
    <div class='etcalc-window'>
        <div class="etcalc-window__content">
        <img id="etcalc-window__close-button" class="etcalc-window__close" src="<?php echo WP_PLUGIN_URL ?>/etcalc/resources/close.svg">
            <div class="etcalc-window__content-wrapper hidden">
                <h1 class="etcalc-window__title">
                    <?php echo __('What you want to calculate?', 'etcalc') ?>
                </h1>
                <div class="etcalc-window__buttons-wrapper">
                    <button class="etcalc-window__button">
                        <span class="etcalc-window__button-text">
                            <?php echo __('Mileage', 'etcalc') ?>
                        </span>
                    </button>
                    <button class="etcalc-window__button">
                        <span class="etcalc-window__button-text">
                            <?php echo __('Battery consumption rate', 'etcalc') ?>
                        </span>
                    </button>
                </div>
            </div>
            <div class="etcalc-window__content-wrapper">
                
            </div>
            <h2 class="etcalc-window__subtitle"><?php echo __('Attention! This calculator calculates values that are much closer to reality, in contrast to those indicated by the manufacturer. However, it is not 100 percent, it calculates only approximate values.', 'etcalc') ?></h2>
        </div>
    </div>
<?php
}
