# Configuration file for the Sphinx documentation builder.
#
# For the full list of built-in configuration values, see the documentation:
# https://www.sphinx-doc.org/en/master/usage/configuration.html

# -- Project information -----------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#project-information

project = 'PMS Booking Service'
copyright = '2025, Jose Antonio'
author = 'Jose Antonio'
release = '1.0.0'

# -- General configuration ---------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#general-configuration

extensions = [
    'myst_parser',
    'sphinx.ext.autodoc',
    'sphinx.ext.viewcode',
    'sphinx.ext.napoleon',
    'sphinx_copybutton',
    'sphinx_design',
    'sphinx.ext.mathjax',
    'sphinx_jinja',
    "sphinx_revealjs",
]
myst_heading_anchors = 3
myst_footnote_transition = True
myst_dmath_double_inline = True
myst_enable_extensions = [
    'amsmath',
    'colon_fence',
    'deflist',
    'dollarmath',
    'fieldlist',
    'html_admonition',
    'html_image',
    'linkify',
    'replacements',
    'smartquotes',
    'substitution',
    'tasklist',
]

templates_path = ['_templates']
exclude_patterns = []



# -- Options for HTML output -------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#options-for-html-output

html_theme = 'shibuya'
html_static_path = ['_static']
html_css_files = ['custom-tab.css']
html_theme_options = {
    "page_layout": "compact",
}
html_sidebars = {
  "**": [
    "sidebars/localtoc.html"
  ]
}
revealjs_style_theme = "moon"
revealjs_static_path = ['_static']
revealjs_script_conf = """
{
  controls: true,
  progress: true,
  transition: 'slide'
}
"""
revealjs_script_plugins = [
    {
        "name": "RevealNotes",
        "src": "revealjs4/plugin/notes/notes.js",
        "src": "revealjs/plugin/notes/notes.js",
    },
    {
        "name": "RevealHighlight",
        "src": "revealjs4/plugin/highlight/highlight.js",
        "src": "revealjs/plugin/highlight/highlight.js",
        "options": """
            {async: true, callback: function() { hljs.initHighlightingOnLoad(); } }
        """
    },
]