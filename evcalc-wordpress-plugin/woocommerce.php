<?php


// Хуки
add_action('woocommerce_after_shop_loop_item', 'replace_add_to_cart'); // Хук для добавления кнопки на страницу товара
add_filter('woocommerce_product_data_tabs', 'etcalcAddProductSettingsTab', 10, 1); // Хук для кастомной вкладки

function add_calculator_button()
{
}

add_action('woocommerce_product_options_general_product_data', 'art_woo_add_custom_fields');

function etcalc_woo_add_custom_fields()
{
    global $product, $post;
    echo '<div class="options_group">';

    echo '</div>';
}

function etcalcAddProductSettingsTab($tabs) // Функция для создания вкладки настройки ETCalc на этом товаре
{
    $tabs['special_panel'] = array(
        'label'    => 'ETCalc', // название вкладки
        'target'   => 'etcalc_plugin_product_data', // идентификатор вкладки
        'class'    => array('show_if_simple'), // Показывать только когда товар простой
        'priority' => 1, // приоритет вывода
    );

    return $tabs;
}
