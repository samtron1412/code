find . -type f -name '*.class' -exec rm -r {} +
find . -type d -name '*pycache*' -exec rm -r {} +
