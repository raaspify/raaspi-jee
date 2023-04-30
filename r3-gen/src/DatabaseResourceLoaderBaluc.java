public class CompetenceBundle extends ResourceBundle {

    protected static final String BASE_NAME = "Competence.messages"; // Can be name of @NamedQuery
    protected static final Control DB_CONTROL = new DBControl();

    private Map<String, String> messages;

    public CompetenceBundle() {
        setParent(ResourceBundle.getBundle(BASE_NAME, 
            FacesContext.getCurrentInstance().getViewRoot().getLocale(), DB_CONTROL));
    }

    protected CompetenceBundle(Map<String, String> messages) {
        this.messages = messages;
    }

    @Override
    protected Object handleGetObject(String key) {
        return messages != null ? messages.get(key) : parent.getObject(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        return messages != null ? Collections.enumeration(messages.keySet()) : parent.getKeys();
    }

    protected static class DBControl extends Control {

        @Override
        public ResourceBundle newBundle
            (String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException, IOException
        {
            String language = locale.getLanguage();
            Map<String, String> messages = getItSomehow(baseName, language); // Do your JPA thing. The baseName can be used as @NamedQuery name.
            return new CompetenceBundle(messages);
        }

    }

}