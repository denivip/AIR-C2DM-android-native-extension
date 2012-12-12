#!/bin/bash 

echo "AIR Native Extension compiler launch"
echo "===================================="
echo "Parameters:"
source "config.sh"
echo "===================================="

echo 
echo "unzip ${library_SWC} -d ${library_directory}/bin"
unzip "${library_SWC}" -d "${library_directory}/bin"

echo
echo "cp ${library_directory}/bin/library.swf ${native_directory}/library.swf"
cp "${library_directory}/bin/library.swf" "${native_directory}/library.swf"

echo
echo "Compile attempt:"
echo ${adt_directory}/adt -package ${signing_options} -target ane ${dest_ANE} ${extension_XML} -swc ${library_SWC} -platform Android-ARM -C ${native_directory} .
"${adt_directory}"/adt -package ${signing_options} -target ane "${dest_ANE}" "${extension_XML}" -swc "${library_SWC}" -platform Android-ARM -C "${native_directory}" .

echo
echo "Finished"
