# PMS Booking Service Documentation

<iframe src="slides/overview.html" width="100%" height="300px" style="border:1px solid #ccc;"></iframe>

---

::::{grid} 2
:::{grid-item}
:columns: auto

```{button-link} tutorial/getting_started.html 
:color: primary
:shadow:
Get Started
```

:::
:::{grid-item}

```{button-link} reference/api-reference.html
:color: info
:outline:
:shadow: 
API Reference
```

:::
::::

::::::::{tab-set}
:::::::{tab-item} Overview
::::::{card}
:class-header: sd-bg-light sd-bg-dark:dark sd-text-black sd-text-white:dark

**Documentation Overview** \
*Learn about the PMS Booking Service documentation system.*
^^^^^^
This documentation system is built using Sphinx, following the Diátaxis framework. It provides
comprehensive information about the PMS Booking Service, including tutorials, how-to guides, technical reference, and
explanatory content.

:::::{grid} 1 1 2 2
:class-container: sd-equal-height
:gutter: 2

::::{grid-item-card} <i class="i-lucide cricle-help"></i> Tutorials
Step-by-step lessons that take the reader by the hand through a series of steps to complete a project.
::::
::::{grid-item-card} <i class="i-lucide file-text"></i>  How-to Guides
Practical guides and recipes that solve specific problems or tasks.
::::
::::{grid-item-card} <i class="i-lucide book-open"></i> Reference
Technical descriptions of the machinery and how to operate it.
::::
::::{grid-item-card} <i class="i-lucide lightbulb"></i> Explanation
Background information that explains why things are the way they are.
::::
::::{grid-item}

```{button-link} https://diataxis.fr/
:class: sd-border-3 sd-text-black sd-btn-outline-primary 
:shadow:
Learn more about Diátaxis
```

::::
:::::
::::::
:::::::

:::::::{tab-item} Structure
::::::{card} Documentation Structure
Visualize how the documentation is organized
::::::
:::::::
::::::::

## Documentation Sections

::::{grid} 1 1 2 2
:class-container: sd-equal-height
:gutter: 2

:::{card}
:class-header: sd-bg-light sd-bg-dark:dark sd-text-black sd-text-white:dark
:class-body: sd-py-2

<i class="i-lucide cricle-help"></i> **Tutorials** \
*Learning-oriented guides for beginners*
^^^^^^

```{toctree}
:maxdepth: 1
tutorial/getting_started.md
tutorial/development_environment.md
```

```{button-link} https://example.com
:class: sd-border-3 sd-text-black sd-btn-outline-primary 
:shadow:

View All Tutorials
```

:::
:::{card}
:class-header: sd-bg-light sd-bg-dark:dark sd-text-black sd-text-white:dark
:class-body: sd-py-2

<i class="i-lucide file-text"></i> **How-to Guides** \
*Problem-oriented guides for specific tasks*
^^^^^^

```{toctree}
:maxdepth: 1
guide/how_to_local_mode.md
guide/how_to_docker_mode.md
```

```{button-link} https://example.com
:class: sd-border-3 sd-text-black sd-btn-outline-primary 
:shadow:

View All How-to Guides
```

:::
:::{card}
:class-header: sd-bg-light sd-bg-dark:dark sd-text-black sd-text-white:dark
:class-body: sd-py-2

<i class="i-lucide book-open"></i> **Reference** \
*Information-oriented technical descriptions*
^^^^^^

```{toctree}
:maxdepth: 1
reference/api-reference.md
reference/domain/index.md
```

```{button-link} https://example.com
:class: sd-border-3 sd-text-black sd-btn-outline-primary 
:shadow:

View All References
```

:::

:::{card}
:class-header: sd-bg-light sd-bg-dark:dark sd-text-black sd-text-white:dark
:class-body: sd-py-2

<i class="i-lucide lightbulb"></i> **Explanation** \
*Understanding-oriented background information*
^^^^^^
System Architecture \
Booking Workflow Explained \
Security Model

```{button-link} https://example.com
:class: sd-border-3 sd-text-black sd-btn-outline-primary 
:shadow:

View All Explanation
```

:::
::::