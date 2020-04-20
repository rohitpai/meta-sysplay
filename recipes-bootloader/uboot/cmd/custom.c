#include <common.h>
#include <command.h>
#include <asm/gpio.h>
#include <errno.h>
#include <linux/err.h>
#include <linux/delay.h>
#include <linux/libfdt.h>

int do_custom(cmd_tbl_t *cmdtp, int flag, int argc, char * const argv[])
{
	int value = 0;
	int gpio = 0;

	printf("\nWelcome to custom command console of Uboot\n");
	if(argc < 2){
		return 0;
	}
	int blink_times = simple_strtoul(argv[1], NULL, 10);

	int statusled = fdt_path_offset(gd->fdt_blob, "/statusled");
	int gpionode = fdt_first_subnode(gd->fdt_blob, statusled);
	const char *proppin = "pin";
	const fdt32_t *pin = fdt_getprop(gd->fdt_blob, gpionode, proppin, 0);

	gpio = (*pin) >> 24;
	int ret = gpio_request(gpio, "cmd_custom");
	if (ret && ret != -EBUSY) {
		printf("gpio: requesting pin %u failed\n", gpio);
		return -1;
	}

	gpio_direction_output(gpio, value);
	printf("\nBlinking LED Starting \n");

	for(int i = 0; i < blink_times; i++){
		value = !value;
		gpio_set_value(gpio, value);
		udelay(500000);
		printf(" * ");
	}
	printf("\nBlinking LED Done\n");
	
	gpio_free(gpio);
	return 0;
}

U_BOOT_CMD(
	custom, 4, 1, do_custom,
	"Utility to manage custom commands",
	"Utility to manage custom commands"
);
