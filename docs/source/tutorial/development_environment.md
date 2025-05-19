# Integration Development Environment

## Setup Intellij

- Download [Intellij](https://www.jetbrains.com/products/compare/?product=idea-ce&product=idea)
- Install plugins:

    - Docker
    - Lombok
    - google-java-format
    - PMD
    - CheckStyle-IDEA

## Configure plugin:

- `Build, Execution, Deployment -> Compiler -> Annotation Proccessors -> [x] Enable annotation processing `
- `Settings -> google-java-format-settings -> [x] Enable google-java-format `
- `Settings -> Tools -> PMD -> `

  - RuleSets:
    - https://raw.githubusercontent.com/jborgers/PMD-jPinpoint-rules/pmd7/rulesets/java/jpinpoint-java-rules.xml
    - PATH/TO/config/pmd/custom-ruleset.xml
- `Settings -> Tools -> CheckStyle -> [x] Google Checks `

##  Download


```{button-link} ../_static/settings.zip
:color: primary
:shadow:
Download settings.zip
```

## Import Settings

`File -> Manage IDE Settings -> Import Settings -> settings.zip `
