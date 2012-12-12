#!/bin/bash

adt_directory="path to your AIR SDK"
echo "adt_directory = ${adt_directory}"
root_directory="path to your workspace dirrectory"
echo "root_directory = ${root_directory}"
library_directory=${root_directory}"\AS3C2DM\as3c2dm"
echo "library_directory = ${library_directory}"
native_directory=${root_directory}"\AS3C2DM\as3c2dm-native"
echo "native_directory = ${native_directory}"
signing_options="-storetype PKCS12 -storepass your_keystrore_pass -keystore your_keystore.p12"
dest_ANE=c2dm.ane
extension_XML=${library_directory}"\src\extension.xml"
echo "extension_XML = ${extension_XML}"
library_SWC=${library_directory}"\bin\as3c2dm.swc"
echo "library_SWC = ${library_SWC}"
