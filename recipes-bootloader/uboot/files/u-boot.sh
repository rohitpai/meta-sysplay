test -n "${BOOT_ORDER}" || setenv BOOT_ORDER "system0 system1"
test -n "${BOOT_system0_LEFT}" || setenv BOOT_system0_LEFT 3
test -n "${BOOT_system1_LEFT}" || setenv BOOT_system1_LEFT 3

common_bootargs="rw rootfstype=ext4 noinitrd selinux=0 rootwait console=ttyS0,115200n8"
setenv boot_kernel "bootz ${kernel_addr_r} - ${fdt_addr_r}"

setenv bootargs
for BOOT_SLOT in "${BOOT_ORDER}"; do
  if test "x${bootargs}" != "x"; then
    # skip remaining slots
  elif test "x${BOOT_SLOT}" = "xsystem0"; then
    if test ${BOOT_system0_LEFT} -gt 0; then
      echo "Found valid slot system0, ${BOOT_system0_LEFT} attempts remaim"
      setexpr BOOT_system0_LEFT ${BOOT_system0_LEFT} - 1
      setenv bootargs "root=/dev/mmcblk0p2 ${common_bootargs} rauc.slot=system0"
      setenv load_kernel "ext4load mmc 0:2 ${kernel_addr_r} /boot/zImage"
      setenv load_fdt "ext4load mmc 0:2 ${fdt_addr_r} /boot/am335x-boneblack-play.dtb"
    fi
  elif test "x${BOOT_SLOT}" = "xsystem1"; then
    if test ${BOOT_system1_LEFT} -gt 0; then
      echo "Found valid slot system1, ${BOOT_system1_LEFT} attempts remain"
      setexpr BOOT_system0_LEFT ${BOOT_system0_LEFT} - 1
      setenv bootargs "root=/dev/mmcblk0p3 ${common_bootargs} rauc.slot=system1"
      setenv load_kernel "ext4load mmc 0:3 ${kernel_addr_r} /boot/zImage"
      setenv load_fdt "ext4load mmc 0:3 ${fdt_addr_r} /boot/am335x-boneblack-play.dtb"
    fi
  fi
done

if test -n "${bootargs}"; then
  saveenv
else
  echo "No valid slot found, resetting tries to 3"
  setenv BOOT_system0_LEFT 3
  setenv BOOT_system1_LEFT 3
  saveenv
  reset
fi

echo "Loading kernel ${load_kernel}................................"
run load_kernel
echo "Loading device tree ${load_fdt}............................."
run load_fdt
echo "Starting kernel ${boot_kernel} with stats system0:${BOOT_system0_LEFT}, system1:${BOOT_system1_LEFT}"
run boot_kernel